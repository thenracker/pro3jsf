/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.Random;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Petr
 */
@ManagedBean
@RequestScoped
public class GeneratorBean {

    /**
     * Creates a new instance of GeneratorBean
     */
    private Random generator;
    
    public GeneratorBean() {
        generator = new Random();
    }
    
    public int getCislo(){
        return generator.nextInt();
    }
    
}
