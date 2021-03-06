import com.CRM.Role
import com.CRM.User
import com.CRM.UserRole

class BootStrap {

   def init = {

      def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
      def userRole = new Role(authority: 'ROLE_USER').save(flush: true)

      def sda00 = new User(username: 'sda00', password: 'Zxcasd123', firstname:'Дмитрий').save(flush: true)
      def iskandarova = new User(username: 'iskandarova', password: 'kotiki', firstname:'Наталья').save(flush: true)
      def luzenin = new User(username: 'luzenin', password: 'test', firstname:'Сергей').save(flush: true)

      UserRole.create sda00, adminRole
      UserRole.create sda00, userRole
      UserRole.create iskandarova, userRole
      UserRole.create luzenin, userRole

      UserRole.withSession {
         it.flush()
         it.clear()
      }

   }
}