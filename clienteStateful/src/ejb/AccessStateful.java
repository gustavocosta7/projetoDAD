package ejb;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import modelo.ICarrinho;
import modelo.IProdutoService;

/**
 *
 * @author fernando
 */
public class AccessStateful {
    
    private static ICarrinho stateful;
    private static AccessStateful access;
    
    private AccessStateful() throws NamingException {
        InitialContext context = new InitialContext();
        stateful = (ICarrinho) context.lookup("ejb:/dadStateful/!ejb.CarrinhoBean");
        
    }
    
    public static synchronized ICarrinho getInstance() throws NamingException{
        if(access == null){
            access = new AccessStateful();
        }
        return stateful;
    }
}
