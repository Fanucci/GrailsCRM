import com.CRM.Role
import com.CRM.User
import com.CRM.UserRole

class BootStrap {

    def init = { servletContext ->
      def adminRole = new Role(authority: 'ROLE_ADMIN').save()
      def userRole = new Role(authority: 'ROLE_USER').save()

      def a = new User(login: "iskandarova", pass: "kotiki").save()
      def b = new User(login: "luzenin", pass: "parol").save()
      def c = new User(login: "sda00", pass: "Zxcasd123").save()

      UserRole.create c, adminRole
      UserRole.create a, userRole
      UserRole.create b, userRole
    }
    def destroy = {
    }
}
