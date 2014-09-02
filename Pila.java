import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;


// Se describe la clase Pila
public class Pila{	
	private Nodo nodoActual;
	private int size;

	
	// Constructor de la clase Pila
	Pila (){
		nodoActual=null;
		size=0;
		
	}
	
	// Clase Nodo para conformar la pila
	class Nodo{

		private char dato;
		private Nodo previous;
		private Nodo next;
		
		Nodo (char e){// Constructor Nodo
			dato=e;
			previous=null;
			next=null;
			
		}
		
		Nodo (){// Constructor Nodo
			dato=' ';
			previous=null;
			next=null;
			
		}
		
		public char getDato(){ // obtener el dato
			return dato;
		}
		
		public void vaciar(){ // vaciar los campos del nodo
			this.dato=' ';
			this.next=null;
			this.previous=null;
		}
		
		public void setNext(Nodo n){ // Metodo asignar siguiente
			this.next= n;
			
		}
		
		public void setPrevious(Nodo n){ // Metodo asignar anterior
			this.previous= n;
			
		}
		
		public Nodo getNext() // Obtener siguiente
		{
            return next;
			
        }
		public Nodo getPrevious()  // Obtener anterior
		{
            return previous;
        }
		
		
		
		
	}
	
	// metodos de la pila
	public void setNodoActual(Nodo e){ // establecer el nodo actual
		nodoActual=e;
	}
	public void push(Nodo e){ //insertar un nodo en la pila
		if(nodoActual==null){
			setNodoActual(e);
		}
		else{
			e.setPrevious(nodoActual);
			nodoActual.setNext(e);
			setNodoActual(e);
		}
		this.size++;
	}
	
	public void pop(){ // se elimina el nodo del tope de la pila
		Nodo e= new Nodo();
		e= nodoActual.getPrevious();
		nodoActual.vaciar();
		setNodoActual(e);
		this.size--;
	}
	
	public char top(){ // devuelve el dato del nodo en el tope de la pila
		char sim;
		if(this.size==0){
			sim='w';
			return sim;
		}
		else{
			sim= nodoActual.getDato();
			return sim;
		}
	}
	
	public boolean checkBalance(String paren){
		Pila pila1= new Pila();
		for (int i= 0 ; i < paren.length() ; i++)
    	{
			if (paren.charAt(i) == '(' || paren.charAt(i) == '[' || paren.charAt(i) == '{') {
				Nodo nuevo=new Nodo(paren.charAt(i));
    	    	pila1.push(nuevo);
    	    } else {
    	    	if (paren.charAt(i)==')') {
    	    	    if (pila1.top()=='(') {
						pila1.pop();
    	    	    }
					else{
						return false;
					}
				}	
				else{
					if(paren.charAt(i)==']'){
						if(pila1.top()=='['){
							pila1.pop();
						}
						else{
							return false;
						}
					}
				}
				if(paren.charAt(i)=='}'){
					if(pila1.top()=='{'){
						pila1.pop();
					}
					else{
						return false;
					}
				}
					
			}
		}
		
		if (pila1.size!=0){
			return false;
		}
		else{
		return true;
		}
		
	
	}
	
	
	// estructura del programa
	public  static void main(String[] args){
		String parentesis=" ";
		Pila pilaR= new Pila();
				
		 try {
            InputStreamReader in= new InputStreamReader(System.in);

            BufferedReader input = new BufferedReader(in);            

             System.out.print("Digite los el conjunto de parentesis y presione  Enter:"); 

            parentesis = input.readLine();                            

        } catch (IOException io) {

            io.printStackTrace();

        }
		
		boolean resultado=pilaR.checkBalance(parentesis);
		if(resultado==true){
			System.out.print("Los parentesis estan balanceados"); 
		}
		else{
			System.out.print("Los parentesis no estan balanceados:"); 
		}
	}
}