package async

@Mixin(BaseController)
class ApplicationController {

	def emailService
	
	def index(){
		withClosure{ obj ->
			render "Sent"
		}

		render "Sent"
	}

	def send(){
		emailService.send("croteau.mike@gmail.com", "delete@mail.datatundra.com", "Hello", "World")
		render "Sent"
	}
}

