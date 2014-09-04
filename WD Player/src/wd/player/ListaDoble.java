
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
	
	 public void add(String nombre,String artista, String album, String genero,int duracion,String ruta) 
	{
            Nodo nodo = new Nodo(nombre,artista,album,genero,duracion,ruta);

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
	
	public Nodo buscarArtista(String artista){
		if(this.first==null){
			return null;
		}
		else{
			Nodo actual=new Nodo();
			actual=this.first;
			for(int i=0; i<this.size;i++){
				if(actual.getNombre().equals(artista)){
					return actual;
				}
				else{
					actual=actual.getNext();
				}
				
			}
			return null;
		}
		
	}
        public Nodo buscarAlbum(String criterio){
		if(this.first==null){
			return null;
		}
		else{
			Nodo actual=new Nodo();
			actual=this.first;
			for(int i=0; i<this.size;i++){
				if(actual.getNombre().equals(criterio)){
					return actual;
				}
				else{
					actual=actual.getNext();
				}
				
			}
			return null;
		}
		
	}
        
         public Nodo buscarGenero(String criterio){
		if(this.first==null){
			return null;
		}
		else{
			Nodo actual=new Nodo();
			actual=this.first;
			for(int i=0; i<this.size;i++){
				if(actual.getNombre().equals(criterio)){
					return actual;
				}
				else{
					actual=actual.getNext();
				}
				
			}
			return null;
		}
		
	}
          public Nodo buscarCancion(String criterio){
		if(this.first==null){
			return null;
		}
		else{
			Nodo actual=new Nodo();
			actual=this.first;
			for(int i=0; i<this.size;i++){
				if(actual.getNombre().equals(criterio)){
					return actual;
				}
				else{
					actual=actual.getNext();
				}
				
			}
			return null;
		}
		
	}
	

	
}