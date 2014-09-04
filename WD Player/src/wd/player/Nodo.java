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
public class Nodo{

		private String nombre;
		private String artista;
		private String album;
		private String genero;
		private int duracion;
		//private loquesea imagen;
		private File ruta;
		private Nodo previous;
		private Nodo next;
		
		Nodo (String nombre,String artista, String album, String genero,int duracion,File ruta){// Constructor Nodo
			this.nombre=nombre;
			this.artista=artista;
			this.album=album;
			this.genero=genero;
			this.duracion=duracion;
		// this.imagen;
			this.ruta=ruta;
			previous=null;
			next=null;
			
		}
		Nodo(){
			this.nombre=" ";
			this.artista=" ";
			this.album=" ";
			this.genero=" ";
			this.duracion=0;
		// this.imagen;
			this.ruta=null;
			previous=null;
			next=null;
		}
		
				
		public String getNombre(){ // obtener el dato
			return nombre;
		}
		public String getArtista(){ // obtener el dato
			return artista;
		}
		public String getAlbum(){ // obtener el dato
			return album;
		}
		public String getGenero(){ // obtener el dato
			return genero;
		}
		public int getDuracion(){ // obtener el dato
			return duracion;
		}
		public File getRuta(){ // obtener el dato
			return ruta;
		}
		public Nodo getNext() // Obtener siguiente
		{
            return next;
			
        }
	public Nodo getPrevious()  // Obtener anterior
		{
            return previous;
			
        }
		
		public void setNombre(String nombre){ // obtener el dato
			this.nombre=nombre;
		}
		public void setArtista(String artista){ // obtener el dato
			this.artista=artista;
		}
		public void setAlbum(String album){ // obtener el dato
			this.album=album;
		}
		public void setGenero(String genero){ // obtener el dato
			this.genero=genero;
		}
		public void setDuracion(int duracion){ // obtener el dato
			this.duracion=duracion;
		}
		public void setRuta(File ruta){ // obtener el dato
			this.ruta=ruta;
                }
		
		public void setNext(Nodo n){ // Metodo asignar siguiente
			this.next= n;
			
		}
		
		public void setPrevious(Nodo n){ // Metodo asignar anterior
			this.previous= n;
			
		}
		public void vaciar(){
			this.nombre=" ";
			this.artista=" ";
			this.album=" ";
			this.genero=" ";
			this.duracion=0;
		// this.imagen;
			this.ruta=null;
			previous=null;
			next=null;
		}
		
		
	
	}
