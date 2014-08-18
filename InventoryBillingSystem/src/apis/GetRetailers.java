package apis;

import java.util.ArrayList;
import java.util.List;

import Dao.AdminregistereddistributorDao;
import Dao.AdminretailerregistrationDao;
import model.Adminregistereddistributor;
import model.Adminretailerregistration;

public class GetRetailers {
	AdminretailerregistrationDao dao = new AdminretailerregistrationDao();

	public List<Adminretailerregistration> getRetailerByZip(String zip) {
		if (zip.equals(null)) {
			System.err.println("Zip code cannot be null");
		}
		int zipCode = 0;
		try {
			zipCode = Integer.parseInt(zip);
		} catch (Exception e) {
			System.err.println("Cannot convert the zip entered" + e);
		}

		List<Adminretailerregistration> fileteredRetailers = new ArrayList<>();
		List<Adminretailerregistration> allRetailers = dao.read();
		for (Adminretailerregistration retailer : allRetailers) {
			if (retailer.getZipCode() == zipCode) {
				fileteredRetailers.add(retailer);
			}
		}
		return fileteredRetailers;
	}

	public List<Adminretailerregistration> getRetailersWithUnpaidFees() {
		List<Adminretailerregistration> retailers = new ArrayList<Adminretailerregistration>();
		List<Adminretailerregistration> allRetailers = dao.read();
		for (Adminretailerregistration retailer : allRetailers) {
			if (retailer.getStatusoffees().equalsIgnoreCase("unpaid")) {
				retailers.add(retailer);
			}
		}
		return retailers;
	}

	public List<Adminretailerregistration> getRetailerByDistributorId(
			String id) {
		System.out.println("I am getting here");
		System.out.println(id);
		int distributorId =Integer.parseInt(id);
		List<Adminretailerregistration> retailers = new ArrayList<Adminretailerregistration>();
		AdminregistereddistributorDao distributorDao = new AdminregistereddistributorDao();
		Adminregistereddistributor distributor=distributorDao.readUser(distributorId);
		int zip=distributor.getZipcode();
		List<Adminretailerregistration> allRetailers = dao.read();
		for (Adminretailerregistration retailer : allRetailers) {
			if (retailer.getZipCode() == zip) {
				retailers.add(retailer);
			}
		}
		return retailers;
	}

}