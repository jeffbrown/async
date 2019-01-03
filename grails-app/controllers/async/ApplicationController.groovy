package async

@Mixin(BaseController)
class ApplicationController {

	def emailService
	
	def index(){
		withClosure{ obj ->
			[obj: obj]
		}
	}

	def send(){
		emailsService.send("croteau.mike@gmail.com", "delete@mail.datatundra.com", "Hello", "World")
	}
}

