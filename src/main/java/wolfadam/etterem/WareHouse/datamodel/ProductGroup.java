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
public class ProductGroup {
    private String name;
    private String description;
    private Product product;
    
    @Builder
    public ProductGroup(String name) {
        this.name = name;
    }
}
