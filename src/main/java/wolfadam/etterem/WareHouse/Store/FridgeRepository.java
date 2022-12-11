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
import wolfadam.etterem.WareHouse.datamodel.Fridge;
import wolfadam.etterem.WareHouse.datamodel.Shelf;

/**
 *
 * @author fluxu
 */
public class FridgeRepository {
    private static final List<Fridge> fridges = new ArrayList<>();
    
     public List<Fridge> getAllFridge(){
        return fridges;
    }
     
    /**
 * Hütő lekérdezés név alapján
 * @param pName hütő egyedi neve
 * @throws java.lang.NullPointerException Nincs ilyen nevű hütő
 * @return hütő
 */    
    public Fridge getByName(String pName) throws NullPointerException{
        Optional<Fridge> tmp = getOptionalByName(pName);
        if(tmp.isEmpty()) throw new NullPointerException();
        return tmp.get();
    }
    
    /**
 * Hütő lekérdezés név alapján
 * @param pName hütő egyedi neve
 * @return hütő
 */    
    public Optional<Fridge> getOptionalByName(String pName){
        Optional<Fridge> res =fridges.stream().filter(element -> element.getName().equals(pName)).findFirst();
        return res;
    }
    
    /**
 * Új hütő létesítése az étteremben
 * @param pFridge az új hütő leírása
 * @throws java.lang.Exception  ha már ilyen névvel létezik hütő
 */    
    public void add(Fridge pFridge) throws Exception{
        if(getOptionalByName(pFridge.getName()).isEmpty()){
            FridgeRepository.fridges.add(pFridge);
        }
        else throw new Exception();
    }
       
    
    /**
 * Meglévő hütő megszüntetése az étteremben
 * @param pFridge a hütő leírása
 * @return sikeres művelet esetén true;
 */    
    public boolean delete(Fridge pFridge){
        return FridgeRepository.fridges.remove(pFridge);
    }
    
    /**
 * Meglévő hütő módosítása az étteremben
 * @param pFridge a módosítandó hütő leírása
 * @throws java.lang.IllegalAccessException
 * @throws java.lang.reflect.InvocationTargetException
 */    
    public void modify(Fridge pFridge) throws IllegalAccessException, InvocationTargetException{
        Optional<Fridge> tmp = getOptionalByName(pFridge.getName());
        if(!tmp.isEmpty()){
            BeanUtils.copyProperties(tmp.get(), pFridge);
        }
    }
/**
 * Meglévő hütő megszüntetése az étteremben
 * @param pName a hütő neve
 * @return sikeres művelet esetén true;
 */    
    public boolean delete(String pName){
        Optional<Fridge> tmp = getOptionalByName(pName);
        if(tmp.isEmpty()) return false;
        return FridgeRepository.fridges.remove(tmp.get());
    }    
    
      public void reduceCapacity(String fridgeName, int amount){ 
           Optional<Fridge> opt = getOptionalByName(fridgeName);
           Fridge actualFridge = opt.get();
           boolean stillFits = actualFridge.getActualCapacity() >= amount;
        if(!opt.isEmpty() && stillFits){
            int newCapacity = actualFridge.getActualCapacity() - amount;
            actualFridge.setActualCapacity(newCapacity);
        }     
    }
    
    public void freesUpCapacity(String fridgeName, int amount) {
        Optional<Fridge> opt = getOptionalByName(fridgeName);
        Fridge actualFridge = opt.get();
        int newCapacity = actualFridge.getActualCapacity() + amount;
        actualFridge.setActualCapacity(newCapacity);
    }
}
