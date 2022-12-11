/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wolfadam.etterem.WareHouse.datamodel;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *
 * @author fluxu
 */
@Data
@EqualsAndHashCode()
@NoArgsConstructor
public class Shelf {

    public int getActualCapacity() {
       
    return this.capacity;
    }
    
     public String getName() {
       
    return this.name;
    }

    public void setActualCapacity(int newCapacity) {
        
        this.capacity = newCapacity;   
    }
    
    public enum Storey {
    First,
    Second,
    Third,
    Fourth,
    Fifth,
    Sixth,
    Seventh,
    Eighth,
    Nineth    
    }
    
    private String name;   
    private int capacity;
    private Storey storeyLevel;
    private List<Product> products;
    
    /**
     *
     * @param name
     * @param capacity
     * @param storeyLevel
     */
    @Builder
    public Shelf(String name, int capacity, Storey storeyLevel) {
        this.name = name;        
        this.capacity = capacity;
        this.storeyLevel = storeyLevel;
    }
    
}
