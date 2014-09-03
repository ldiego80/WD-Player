/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wd.player;
import java.io.File;
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
	
	 public void add(Nodo nodo) 
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
		{	nodo.setPrevious(this.last);
			nodo.setNext(this.last.getNext() );
			this.last.setNext(nodo);
			this.last = nodo;
		}

		this.size++;
    }
         public void delete(String criterio){
             
			//Nodo actual=new Nodo();
                	Nodo actual=this.first;
                        
			for(int i=0; i<this.size;i++){
                            Nodo pre=actual.getPrevious();
                            Nodo nextt= actual.getNext();
				if(actual.getNombre().equals(criterio)){
					pre.setNext(actual.getNext());
                                        nextt.setPrevious(actual.getPrevious());
                                        actual.vaciar();
                                        this.size--;
                                    
				}
				else{
					actual=actual.getNext();
				}
				
			}
			
		}
         
	
	public ListaDoble buscarArtista(String criterio){
		if(this.size==0){
			return null;
		}
		else{
			//Nodo actual=new Nodo();
                        ListaDoble Resultado= new ListaDoble();
			Nodo actual=this.first;
			for(int i=0; i<this.size;i++){
				if(actual.getNombre().equals(criterio)){
					Resultado.add(actual);
				}
				else{
					actual=actual.getNext();
				}
				
			}
			return null;
		}
		
	}
        public Nodo buscarAlbum(String criterio){
		if(this.size==0){
			return null;
		}
		else{
			//Nodo actual=new Nodo();
                        ListaDoble Resultado= new ListaDoble();
			Nodo actual=this.first;
			for(int i=0; i<this.size;i++){
				if(actual.getNombre().equals(criterio)){
					Resultado.add(actual);
				}
				else{
					actual=actual.getNext();
				}
				
			}
			return null;
		}
		
	}
        
         public Nodo buscarGenero(String criterio){
		if(this.size==0){
			return null;
		}
		else{
			//Nodo actual=new Nodo();
                        ListaDoble Resultado= new ListaDoble();
			Nodo actual=this.first;
			for(int i=0; i<this.size;i++){
				if(actual.getNombre().equals(criterio)){
					Resultado.add(actual);
				}
				else{
					actual=actual.getNext();
				}
				
			}
			return null;
		}
		
		
	}
          public Nodo buscarCancion(String criterio){
		if(this.size==0){
			return null;
		}
		else{
			//Nodo actual=new Nodo();
                        ListaDoble Resultado= new ListaDoble();
			Nodo actual=this.first;
			for(int i=0; i<this.size;i++){
				if(actual.getNombre().equals(criterio)){
					Resultado.add(actual);
				}
				else{
					actual=actual.getNext();
				}
				
			}
			return null;
		}
		
	}
	

	
}
