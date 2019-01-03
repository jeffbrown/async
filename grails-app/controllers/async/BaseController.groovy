package async

import static grails.async.Promises.*

class BaseController {
	
	def emailService
	
	BaseController(){
		if(!emailService){
			emailService = grailsApplication.classLoader.loadClass("async.EmailService").newInstance()
		}
	}

	private def withClosure(Closure c){
		def to = "croteau.mike@gmail.com"
		def from = "delete@mail.datatundra.com"
		def subject = "hello"
		def body = "world"	
		def messages = task {
			println "*** sending emails ***"
			sendEmails(to, from, subject, body)		
		}
		onError([messages]) { Throwable t ->
			println "**** errored sending messages ****"
			t.properties.each{ println "${it.key} : ${it.value}"}
		}
		onComplete([messages]){
			println "everything was sent...."
		}
	}
	
	def sendEmails(to, from, subject, body){
		emailService.send(to, from, subject, body)

	}

}
