
package ejb;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import modelo.IProdutoService;

public class AccessStateless {

    private static AccessStateless access;
    private static IProdutoService produto;
    
    private AccessStateless() throws NamingException {
        InitialContext context = new InitialContext();
        produto = (IProdutoService) context.lookup("ejb:/dadStateless/ProdutoService!modelo.IProdutoService");
    }
    
    public static synchronized IProdutoService getInstace() throws NamingException{
        if (access == null){
            access = new AccessStateless();
        }
        return produto;
    }
}
