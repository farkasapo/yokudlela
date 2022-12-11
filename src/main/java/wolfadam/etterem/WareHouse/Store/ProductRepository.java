/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wolfadam.etterem.WareHouse.Store;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.apache.commons.beanutils.BeanUtils;
import wolfadam.etterem.WareHouse.datamodel.Fridge;
import wolfadam.etterem.WareHouse.datamodel.Product;
import wolfadam.etterem.WareHouse.datamodel.Shelf;

/**
 *
 * @author fluxu
 */
public class ProductRepository {
    private static final List<Product> products = new ArrayList<>();
    
     
    /**
 * Termék lekérdezés név alapján
 * @param pName termék egyedi neve
 * @throws java.lang.NullPointerException Nincs ilyen nevű termék
 * @return termék
 */    
    public Product getByName(String pName) throws NullPointerException{
        Optional<Product> tmp = getOptionalByName(pName);
        if(tmp.isEmpty()) throw new NullPointerException();
        return tmp.get();
    }
    
    /**
 * Termék lekérdezés név alapján
 * @param pName termék egyedi neve
 * @return termék
 */    
    public Optional<Product> getOptionalByName(String pName){
        Optional<Product> res =products.stream().filter(element -> element.getName().equals(pName)).findFirst();
        return res;
    }
    
    /**
 * Új termék létesítése
 * @param pProduct az új termék leírása
 * @throws java.lang.Exception ha már ilyen névvel létezik termék
 */    
    public void add(Product pProduct) throws Exception{
        if(getOptionalByName(pProduct.getName()).isEmpty()){
            ProductRepository.products.add(pProduct);
        }
        else throw new Exception();
    }
       
    
    /**
 * Meglévő termék megszüntetése
 * @param pProduct a termék leírása
 * @return sikeres művelet esetén true;
 */    
    public boolean delete(Product pProduct){
        return ProductRepository.products.remove(pProduct);
    }
    
    /**
 * Meglévő termék módosítása 
 * @param pProduct a módosítandó termék leírása
 * @throws java.lang.IllegalAccessException
 * @throws java.lang.reflect.InvocationTargetException
 */    
    public void modify(Product pProduct) throws IllegalAccessException, InvocationTargetException{
        Optional<Product> tmp = getOptionalByName(pProduct.getName());
        if(!tmp.isEmpty()){
            BeanUtils.copyProperties(tmp.get(), pProduct);
        }
    }
/**
 * Meglévő termék megszüntetése
 * @param pName a termék neve
 * @return sikeres művelet esetén true;
 */    
    public boolean delete(String pName){
        Optional<Product> tmp = getOptionalByName(pName);
        if(tmp.isEmpty()) return false;
        return ProductRepository.products.remove(tmp.get());
    }    
    
    /**
     * Adott dátum után lejáró termékek listája
     * @param pExpirationDate a termék lejárati dátuma
     * @return a lejáró termékek listája
     */
    public List<Product> getExpiringProducts(LocalDate pExpirationDate) {
        List<Product> res = products.stream().filter(
        element -> (element.getExpirationDate().isEqual(pExpirationDate)
                || element.getExpirationDate().isBefore(pExpirationDate))).toList();
        
        return res;
    }


/**
     * Adott dátum után lejáró termékek selejtezése/törlése
     * @param pExpirationDate a termék lejárati dátuma
     * @return sikeres művelet esetén true;
     * 
     */
    public boolean Disposal(LocalDate pExpirationDate){
        List<Product> disposable = getExpiringProducts(pExpirationDate);
        if (disposable.isEmpty()) {
            return false;   }
        return products.removeAll(disposable);       
        
}
    /**
     * Áru beérkezés a raktárba, polcra
     * @param product a bevételezni kívánt termék
     * @param wareHouseName melyik raktárba kerül
     * @param shelf melyik polcra kerül
     */
    public void IncomingProductToShelf(Product product, String wareHouseName, Shelf shelf){
        
    }
    /**
     * Áru beérkezés a raktárba, hütőbe
     * @param product a bevételezni kívánt termék
     * @param wareHouseName melyik raktárba kerül
     * @param fridge melyik hütőbe kerül
     */
    public void IncomingProductToFridge(Product product, String wareHouseName, Fridge fridge) {
        
    }
}