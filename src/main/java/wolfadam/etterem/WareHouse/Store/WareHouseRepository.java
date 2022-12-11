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
import wolfadam.etterem.WareHouse.datamodel.Product;
import wolfadam.etterem.WareHouse.datamodel.WareHouse;

/**
 *
 * @author fluxu
 */
public class WareHouseRepository {
    private static final List<WareHouse> warehouses = new ArrayList<>();
    
    /**
 * Raktár lekérdezés név alapján
 * @param pName raktár egyedi neve
 * @throws java.lang.NullPointerException Nincs ilyen nevű raktár
 * @return raktár
 */    
    public WareHouse getByName(String pName) throws NullPointerException{
        Optional<WareHouse> tmp = getOptionalByName(pName);
        if(tmp.isEmpty()) throw new NullPointerException();
        return tmp.get();
    }
    
    /**
 * Raktár lekérdezés név alapján
 * @param pName raktár egyedi neve
 * @return raktár
 */    
    public Optional<WareHouse> getOptionalByName(String pName){
        Optional<WareHouse> res =warehouses.stream().filter(element -> element.getName().equals(pName)).findFirst();
        return res;
    }
    
    /**
 * Új raktár létesítése az étteremben
 * @param pWarehouse az új raktár leírása
 * @throws java.lang.Exception  ha már ilyen névvel létezik raktár
 */    
    public void add(WareHouse pWarehouse) throws Exception{
        if(getOptionalByName(pWarehouse.getName()).isEmpty()){
            WareHouseRepository.warehouses.add(pWarehouse);
        }
        else throw new Exception();
    }
    
    /**
 * Meglvő raktár módosítása az étteremben
 * @param pWareHouse a raktár leírása
 * @throws java.lang.IllegalAccessException
 * @throws java.lang.reflect.InvocationTargetException
 */    
    public void modify(WareHouse pWareHouse) throws IllegalAccessException, InvocationTargetException{
        Optional<WareHouse> tmp = getOptionalByName(pWareHouse.getName());
        if(!tmp.isEmpty()){
            BeanUtils.copyProperties(tmp.get(), pWareHouse);
        }
    }
    
    /**
 * Meglévő raktár megszüntetése az étteremben
 * @param pWarehouse a raktár leírása
 * @return sikeres művelet esetén true;
 */    
    public boolean delete(WareHouse pWarehouse){
        return WareHouseRepository.warehouses.remove(pWarehouse);
    }
    
    /**
 * Meglévő raktár megszüntetése az étteremben
 * @param pName a raktár neve
 * @return sikeres művelet esetén true;
 */    
    public boolean delete(String pName){
        Optional<WareHouse> tmp = getOptionalByName(pName);
        if(tmp.isEmpty()) return false;
        return WareHouseRepository.warehouses.remove(tmp.get());
    }  
    
    
}
