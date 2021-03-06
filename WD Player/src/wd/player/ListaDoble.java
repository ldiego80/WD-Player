
package wd.player;

import javax.swing.DefaultListModel;

/**
 *
 * @author Way
 */

public class ListaDoble{
	private Nodo first=null;
	private Nodo last=null;
	private int size;
	
	
	ListaDoble(){// constructor
		first=null;
		last=null;
		size=0;
	}
	
	 public boolean add(Nodo nodo) 
        {            
            // caso de lista vacía
            if (this.size == 0) 
            { 
                this.first = nodo;
                this.last = nodo;
                this.first.setPrevious(this.last);
                this.first.setNext(this.last);
                
   
            }
            else 
            { nodo.setPrevious(this.last);
              nodo.setNext(this.last.getNext() );
              this.last.setNext(nodo);
              this.last = nodo;
              
            }
            if(this.last==nodo){
                size++;
                return true;
            }
            else{ return false;}
            
        }
         public Nodo getLast(){
             return this.last;
         }
         public Nodo buscarNodo(int n){
             Nodo resul=new Nodo();
             if(this.size>0){
                 resul= this.first;
                 for(int i=0;i<=n; i++){
                     if(i==n){
                         return resul;
                     }
                     else{
                         resul=resul.getNext();
                     }
                 }
                 
             }
             return null;
         }
         
         public DefaultListModel cargarLista(){
             DefaultListModel modelo= new DefaultListModel();
             Nodo actual=this.first;
             for(int i=0;i<this.size;i++){
                 modelo.addElement(actual.getNombre());
                 actual=actual.getNext();
             }
             return modelo;
         }
         public int tamano(){
             int n=0;
             Nodo actual=this.first;
             for(int i=0;i<this.size;i++){
                 n++;
                 actual=actual.getNext();
             }
             return n;
         }
         public boolean delete(int n){
             
            //Nodo actual=new Nodo();
                 Nodo actual=this.first;
                        
                 for(int i=0; i<=n;i++){
                            Nodo pre=actual.getPrevious();
                            Nodo nextt= actual.getNext();
                            if(i==n){
                                pre.setNext(nextt);
                                nextt.setPrevious(pre);
                                actual.vaciar();
                                this.size--;
                                 return true;
                            }
                            else{
                                actual=actual.getNext();
                            }
    
                   }
                 return false;
   
        }
	
         public boolean modificar(int index, Nodo cambio){
             Nodo actual=this.first;
                        
                 for(int i=0; i<=index;i++){
                           if(i==index){
                                actual=cambio;
                                 return true;
                           }
                         
                            else{
                                actual=actual.getNext();
                            }
    
                   }
                 return false;
   
         }
         
	public ListaDoble buscarArtista(String criterio){
	 ListaDoble Resultado= new ListaDoble();	
            if(this.size==0){
			return null;
		}
		else{
			//Nodo actual=new Nodo();
                        
			Nodo actual=this.first;
			for(int i=0; i<this.size;i++){
				if(actual.getArtista().startsWith(criterio)){
					Resultado.add(actual);
				}
				else{
					actual=actual.getNext();
				}
				
			}
                        return Resultado;
			
		}
		
	}
        public ListaDoble buscarAlbum(String criterio){
		if(this.size==0){
			return null;
		}
		else{
			//Nodo actual=new Nodo();
                        ListaDoble Resultado= new ListaDoble();
			Nodo actual=this.first;
			for(int i=0; i<this.size;i++){
				if(actual.getAlbum().startsWith(criterio)){
					Resultado.add(actual);
				}
				else{
					actual=actual.getNext();
				}
				
			}
			return Resultado;
		}
		
	}
        
           public ListaDoble buscarGenero(String criterio){
		if(this.size==0){
			return null;
		}
		else{
			//Nodo actual=new Nodo();
                        ListaDoble Resultado= new ListaDoble();
			Nodo actual=this.first;
			for(int i=0; i<this.size;i++){
				if(actual.getGenero().startsWith(criterio)){
					Resultado.add(actual);
				}
				else{
					actual=actual.getNext();
				}
				
			}
			return Resultado;
		}
		
	}
          public ListaDoble buscarCancion(String criterio){
		if(this.size==0){
			return null;
		}
		else{
			//Nodo actual=new Nodo();
                        ListaDoble Resultado= new ListaDoble();
			Nodo actual=this.first;
			for(int i=0; i<this.size;i++){
				if(actual.getNombre().startsWith(criterio)){
					Resultado.add(actual);
				}
				else{
					actual=actual.getNext();
				}
				
			}
			return Resultado;
		}
		
	}
	

	
}