package download
import grails.plugin.springsecurity.annotation.Secured
@Secured('ROLE_USER')
class MainpageController {

    def index() { }
    
    def renderContact(){
    String content = g.render(template:"bookTemplate"/*, model:[book:b]*/)
    render content
    }
}
