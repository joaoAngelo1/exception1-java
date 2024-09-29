
package model.exception;

/**
 *
 * @author eucli
 */
public class DomainException extends RuntimeException {
    //runtime exception nao precisa ser tratada
    
    private static final long serialVersionUID = 1L;
    
    
    public DomainException(String msg){
        super(msg);
    }
}
