/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wolfadam.etterem.WareHouse.Store;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.apache.commons.beanutils.BeanUtils;
import wolfadam.etterem.WareHouse.datamodel.Shelf;

/**
 *
 * @author fluxu
 */
public class ShelfRepository {
    private static final List<Shelf> shelves = new ArrayList<>();
    
    public List<Shelf> getAllShelf(){
        return shelves;
    }
     
    /**
 * Polc lekérdezés név alapján
 * @param pName polc egyedi neve
 * @throws java.lang.NullPointerException Nincs ilyen nevű polc
 * @return polc
 */    
    public Shelf getByName(String pName) throws NullPointerException{
        Optional<Shelf> tmp = getOptionalByName(pName);
        if(tmp.isEmpty()) throw new NullPointerException();
        return tmp.get();
    }
    
    /**
 * Polc lekérdezés név alapján
 * @param pName polc egyedi neve
 * @return polc
 */    
    public Optional<Shelf> getOptionalByName(String pName){
        Optional<Shelf> res =shelves.stream().filter(element -> element.getName().equals(pName)).findFirst();
        return res;        
    }  
    
    
    
    public void reduceCapacity(String shelfName, int amount){ 
           Optional<Shelf> opt = getOptionalByName(shelfName);
           Shelf actualShelf = opt.get();
           boolean stillFits = actualShelf.getActualCapacity() >= amount;
        if(!opt.isEmpty() && stillFits){
            int newCapacity = actualShelf.getActualCapacity() - amount;
            actualShelf.setActualCapacity(newCapacity);
        }     
    }
    
    public void freesUpCapacity(String shelfName, int amount) {
        Optional<Shelf> opt = getOptionalByName(shelfName);
        Shelf actualShelf = opt.get();
        int newCapacity = actualShelf.getActualCapacity() + amount;
        actualShelf.setActualCapacity(newCapacity);
    }
    
    /**
 * Új polc létesítése az étteremben
 * @param pShelf az új polc leírása
 * @throws java.lang.Exception  ha már ilyen névvel létezik polc
 */    
    public void add(Shelf pShelf) throws Exception{
        if(getOptionalByName((String) pShelf.getName()).isEmpty()){
            ShelfRepository.shelves.add(pShelf);
        }
        else throw new Exception();
    }
       
    
    /**
 * Meglévő polc megszüntetése az étteremben
 * @param pShelf a polc leírása
 * @return sikeres művelet esetén true;
 */    
    public boolean delete(Shelf pShelf){
        return ShelfRepository.shelves.remove(pShelf);
    }
    
    /**
 * Meglévő polc módosítása az étteremben
 * @param pShelf a módosítandó polc leírása
 * @throws java.lang.IllegalAccessException
 * @throws java.lang.reflect.InvocationTargetException
 */    
    public void modify(Shelf pShelf) throws IllegalAccessException, InvocationTargetException{
        Optional<Shelf> tmp = getOptionalByName((String) pShelf.getName());
        if(!tmp.isEmpty()){
            BeanUtils.copyProperties(tmp.get(), pShelf);
        }
    }
/**
 * Meglévő polc megszüntetése az étteremben
 * @param pName a polc neve
 * @return sikeres művelet esetén true;
 */    
    public boolean delete(String pName){
        Optional<Shelf> tmp = getOptionalByName(pName);
        if(tmp.isEmpty()) return false;
        return ShelfRepository.shelves.remove(tmp.get());
    }    
}
