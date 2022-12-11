/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wolfadam.etterem.WareHouse.Service;

import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;
import wolfadam.etterem.WareHouse.Store.FridgeRepository;
import wolfadam.etterem.WareHouse.Store.ProductRepository;
import wolfadam.etterem.WareHouse.Store.ShelfRepository;
import wolfadam.etterem.WareHouse.Store.WareHouseRepository;
import wolfadam.etterem.WareHouse.datamodel.Fridge;
import wolfadam.etterem.WareHouse.datamodel.Product;
import wolfadam.etterem.WareHouse.datamodel.Shelf;
import wolfadam.etterem.WareHouse.datamodel.WareHouse;

/**
 *
 * @author fluxu
 */
@Service
public class DisposalService {
    // WareHouseRepository whRepo = new WareHouseRepository();
    ProductRepository pRepo = new ProductRepository();
    FridgeRepository fRepo = new FridgeRepository();
    ShelfRepository sRepo = new ShelfRepository();
    
    public void DisposalProducts(LocalDate pExpirationDate) {
        // List<WareHouse> allWH = 
        List<Product> expiringProducts = pRepo.getExpiringProducts(pExpirationDate);
        List<Shelf> allShelves = sRepo.getAllShelf();
        List<Fridge> allFridges = fRepo.getAllFridge();
        allShelves.removeAll(expiringProducts);
        allFridges.removeAll(expiringProducts);
                pRepo.Disposal(pExpirationDate);
        
        
    }
    
}
