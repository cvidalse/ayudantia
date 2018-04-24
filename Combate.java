/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoayudante;

/**
 *
 * @author Ce
 */
public class Combate {
Monstruo enemigo;
Party aliados;
JuegoDado dado;
InventarioObjeto inventObj;
double ataqueAliado;
double ataqueMonstruo;
double hpHeroe;
double hpMonstruo;

Combate(Monstruo m, Party p, JuegoDado jd, InventarioObjeto io){
aliados=p;
enemigo=m;
dado=jd;
inventObj=io;
combate();
}

private void analizarDados(int i){
if(dado.getValorResta()>0){
/*for(int i=0;i<aliados.party.size();i++){
    
*/
ataqueAliado=aliados.party.get(i).getAtk()*dado.getValorResta();

}else{

    if(dado.getValorResta()<0){
     ataqueMonstruo= enemigo.getAtk()*dado.getValorResta()*-1;
     
}else{

}
}
}
private void analizarFaccion(int i){

    if(aliados.party.get(i).getFaccion().endsWith("agua")&&enemigo.getFaccion().endsWith("fuego")){
    ataqueAliado=this.ataqueAliado*1.5;
    ataqueMonstruo=this.ataqueMonstruo*0.75;
    }else{
        
        if(aliados.party.get(i).getFaccion().endsWith("fuego")&&enemigo.getFaccion().endsWith("planta")){
          ataqueAliado=this.ataqueAliado*1.5;
          ataqueMonstruo=this.ataqueMonstruo*0.75;
        }else{
        
            if(aliados.party.get(i).getFaccion().endsWith("planta")&&enemigo.getFaccion().endsWith("agua")){
               ataqueAliado=this.ataqueAliado*1.5;
               ataqueMonstruo=this.ataqueMonstruo*0.75;
        }else{
             ataqueAliado=this.ataqueAliado*0.75;
             ataqueMonstruo=this.ataqueMonstruo*1.5;     
            }}
    }
}
private double fijarDañoHeroe(int i){
    analizarDados(i);
    analizarFaccion(i);
    double daño =ataqueAliado-enemigo.getDefensa();
return daño;
}
private double fijarDañoMonstruo(int i){
    analizarDados(i);
    analizarFaccion(i);
    double daño =ataqueMonstruo-aliados.party.get(i).getDef();
return daño;
}

private boolean ordenAtaque(int i){
    boolean orden;   
    if(aliados.party.get(i).getSpd()>enemigo.getVelocidad()){
           orden=true;
           System.out.println("el luchador atacara primero");
}
    else{
    orden=false;
    System.out.println("el monstruo atacara primero");
    }
return true;
}

public void combate(){
 hpMonstruo= enemigo.getVida();
 
    for(int i=0;i<aliados.party.size();i++){
    hpHeroe=aliados.party.get(i).getHp();
   
    double dañoM=fijarDañoMonstruo(i);
    double dañoH=fijarDañoHeroe(i);
    boolean orden=ordenAtaque(i);
    do{
    if(orden){
    
    this.hpMonstruo=hpMonstruo+(dañoH);
    
    if(hpMonstruo<0){
    i=aliados.party.size();
    System.out.println("El enemigo a muerto, se agregara un Item a tu inventario");
    enemigo.Dropmuerte(true, inventObj);
    inventObj.mostrarInventario();
    break;
    }  
    //System.out.println("el daño fue increible "+dañoH+"vida"+hpMonstruo);
    
    hpHeroe=this.hpHeroe+dañoM;
     if(hpHeroe<0){
         System.out.println("uno de tus peleadores cayo en batalla");
     break;
     }
//System.out.println(" "+hpHeroe+" daño "+dañoM);
    
    }else{
    
        hpHeroe=this.hpHeroe+dañoM;
        if(hpHeroe<0){
         System.out.println("uno de tus peleadores cayo en batalla");
        
         break;
       // System.out.println("el daño fue increible al heroe"+hpMonstruo);
        }
        
        hpMonstruo=this.hpMonstruo+(dañoH);
        
        if(hpMonstruo<0){
    
            i=aliados.party.size();
    
            System.out.println("El enemigo a muerto, se agregara un Item a tu inventario");
    
            enemigo.Dropmuerte(true, inventObj);
    
            inventObj.mostrarInventario();
   
    break;
    }  
    }
     
  }while(hpMonstruo>0&&hpHeroe>0);
    }
    if(hpMonstruo>0){
System.out.println("todos tus luchadores han sido derrotados");
}
}}
