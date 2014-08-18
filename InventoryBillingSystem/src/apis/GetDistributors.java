package apis;

import java.util.ArrayList;
import java.util.List;
import Dao.AdminregistereddistributorDao;
import model.Adminregistereddistributor;

public class GetDistributors {

	AdminregistereddistributorDao dao = new AdminregistereddistributorDao();
	public List<Adminregistereddistributor> getAllDistributorsByZip(String zipCode){
		int zip=0;
		if(zipCode.equals(null)){
			System.err.println("Zip code cannot be null");
		}
		try{
		zip = Integer.parseInt(zipCode);
		}
		catch(Exception e){
			System.err.println("Some problem with type casting "+e);
		}
		
		List<Adminregistereddistributor> allDistributors = dao.read();
		List<Adminregistereddistributor> distributors =new ArrayList<>();
		for(Adminregistereddistributor distributor: allDistributors){
			if(distributor.getZipcode()==zip){
				distributors.add(distributor);
			}
		}
		return distributors;
	} 
	public List<Adminregistereddistributor> getDistributorsWithUnpaidFees(){
		List<Adminregistereddistributor> distributors = new ArrayList<Adminregistereddistributor>();
		List<Adminregistereddistributor> allDistributors = dao.read();
		for(Adminregistereddistributor distributor:allDistributors){
			if(distributor.getStatusoffees().equalsIgnoreCase("unpaid")){
				distributors.add(distributor);
			}
		}
		return distributors;
    }
}
