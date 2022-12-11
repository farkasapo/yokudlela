/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wolfadam.etterem.WareHouse.datamodel;

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
    
    

//    public int getActualCapacity() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    return this.capacity;
//    }
//
//    public Object getName() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    public void setActualCapacity(int newCapacity) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }

    
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
    private byte id;
    private int capacity;
    private Storey storeyLevel;  
    
    /**
     *
     * @param name
     * @param id
     * @param capacity
     * @param storeyLevel
     */
    @Builder
    public Shelf(String name, byte id, int capacity, Storey storeyLevel) {
        this.name = name;
        this.id = id;
        this.capacity = capacity;
        this.storeyLevel = storeyLevel;
    }
    
}
