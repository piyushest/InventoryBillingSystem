package apis;

import java.util.ArrayList;
import java.util.List;
import Dao.InventoryDao;
import model.Inventory;
import model.InventoryPK;

public class InventoryOperations {
	InventoryDao inventoryDao = new InventoryDao();

	public void addProductsInInventory(String distributorId, String productId,
			String category, String description, String inventorycol,
			String name, String quantityAvailable, String rate) {
		InventoryPK primaryKey = new InventoryPK(distributorId, productId);
		Inventory singleInventory = new Inventory(primaryKey, category,
				description, inventorycol, name, quantityAvailable, rate);
		inventoryDao.create(singleInventory);
	}

	public void updateInventoryProduct(String distributorId, String productId,
			String category, String description, String inventorycol,
			String name, String quantityAvailable, String rate) {
		InventoryPK primaryKey = new InventoryPK(distributorId, productId);
		Inventory singleInventory = new Inventory(primaryKey, category,
				description, inventorycol, name, quantityAvailable, rate);
		inventoryDao.update(singleInventory);
	}

	public List<Inventory> getFullInventoryForDistributor(String distributorId) {
		int distributor =Integer.parseInt(distributorId);
		List<Inventory> fullInventory = new ArrayList<Inventory>();
        List<Inventory> inventoryForAll = inventoryDao.read();
        for(Inventory inv:inventoryForAll){
        	if(inv.getId().getDistributorId()==distributor){
        		fullInventory.add(inv);
        	}
        }
		return fullInventory;
	}
}
