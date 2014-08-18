package apis;

import java.util.List;

import model.Adminregistration;
import model.Distributorlogin;
import Dao.AdminregistrationDao;
import Dao.DistributorLoginDao;

public class Login {

	public boolean isValidUser(String username,String password){
		AdminregistrationDao dao = new AdminregistrationDao();
		List<Adminregistration> allAdmin=dao.read();
		for(Adminregistration admin:allAdmin){
			if(admin.getName().equalsIgnoreCase(username)&&admin.getPassword().equals(password)){
				System.out.println("piyush");
				return true;
			}
		}
		return false;
	}
	public boolean isValidateDistributor(String id,String username,String passowrd){
		int distributorId = Integer.parseInt(id);
		DistributorLoginDao dao = new DistributorLoginDao();
		List<Distributorlogin> allDistributors = dao.read();
		for(Distributorlogin distr:allDistributors){
			if(username.equalsIgnoreCase(distr.getUsername())&& passowrd.equalsIgnoreCase(distr.getPassword())&&distributorId==distr.getId()){
				return true;
			}
		}
		return false;
	}
}
