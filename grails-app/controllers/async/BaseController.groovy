package async

class BaseController {
	
	def emailService

	private def withClosure(Closure c){
		def messages = task {
			println "*** sending emails ***"
			def to = "croteau.mike@gmail.com"
			def from = "delete@mail.datatundra.com"
			def subject = "hello"
			def body = "world"
			
			emailService.send(to, from, subject, body)
			
		}
		onError([messages]) { Throwable t ->
			println "**** errored sending messages ****"
			t.properties.each{ println "${it.key} : ${it.value}"}
		}
		onComplete([messages]){
			println "everything was sent...."
		}
		
	}

}
