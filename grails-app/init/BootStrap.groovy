import com.CRM.Role
import com.CRM.User
import com.CRM.UserRole

class BootStrap {

   def init = {

      def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
      def userRole = new Role(authority: 'ROLE_USER').save(flush: true)

      def testUser = new User(username: 'sda00', password: 'Zxcasd123').save(flush: true)

      UserRole.create testUser, adminRole
      UserRole.create testUser, userRole
      UserRole.withSession {
         it.flush()
         it.clear()
      }


      User p = User.find { username == "sda00" }
      println(p.username)
   }
}