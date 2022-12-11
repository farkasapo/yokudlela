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
import wolfadam.etterem.WareHouse.datamodel.ProductGroup;

/**
 *
 * @author fluxu
 */
public class ProductGroupRepository {
    private static final List<ProductGroup> productGroups = new ArrayList<>();
    
     
    /**
 * Termékcsoport lekérdezés név alapján
 * @param pName termékcsoport egyedi neve
 * @throws java.lang.NullPointerException Nincs ilyen nevű termékcsoport
 * @return termékcsoport
 */    
    public ProductGroup getByName(String pName) throws NullPointerException{
        Optional<ProductGroup> tmp = getOptionalByName(pName);
        if(tmp.isEmpty()) throw new NullPointerException();
        return tmp.get();
    }
    
    /**
 * Termékcsoport lekérdezés név alapján
 * @param pName termékcsdoport egyedi neve
 * @return termékcsoport
 */    
    public Optional<ProductGroup> getOptionalByName(String pName){
        Optional<ProductGroup> res =productGroups.stream().filter(element -> element.getName().equals(pName)).findFirst();
        return res;
    }
    
    /**
 * Új termékcsoport létesítése
 * @param pProductGroup az új termékcsoport leírása
 * @throws java.lang.Exception ha már ilyen névvel létezik termékcsoport
 */    
    public void add(ProductGroup pProductGroup) throws Exception{
        if(getOptionalByName(pProductGroup.getName()).isEmpty()){
            ProductGroupRepository.productGroups.add(pProductGroup);
        }
        else throw new Exception();
    }
       
    
    /**
 * Meglévő termékcsoport megszüntetése
 * @param pProductGroup a termékcsoport leírása
 * @return sikeres művelet esetén true;
 */    
    public boolean delete(ProductGroup pProductGroup){
        return ProductGroupRepository.productGroups.remove(pProductGroup);
    }
    
    /**
 * Meglévő termékcsoport módosítása 
 * @param pProductGroup a módosítandó termékcsoport leírása
 * @throws java.lang.IllegalAccessException
 * @throws java.lang.reflect.InvocationTargetException
 */    
    public void modify(ProductGroup pProductGroup) throws IllegalAccessException, InvocationTargetException{
        Optional<ProductGroup> tmp = getOptionalByName(pProductGroup.getName());
        if(!tmp.isEmpty()){
            BeanUtils.copyProperties(tmp.get(), pProductGroup);
        }
    }
/**
 * Meglévő termékcsoport megszüntetése
 * @param pName a termékcsoport neve
 * @return sikeres művelet esetén true;
 */    
    public boolean delete(String pName){
        Optional<ProductGroup> tmp = getOptionalByName(pName);
        if(tmp.isEmpty()) return false;
        return ProductGroupRepository.productGroups.remove(tmp.get());
    }
}
