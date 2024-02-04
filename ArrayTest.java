public class ArrayTest{


 public static void main(String [] args)
 {
 
 
int [] fiveAside = new int [5];


for(int i = 0; i <  fiveAside.length; i++){

	System.out.println("i = " + i);
	if(i == 3){
	fiveAside[i] = i * 2;
	}
	
	fiveAside[i] = i + 2;

}



for(int i = 0; i <  fiveAside.length; i++){

	System.out.println("fiveAside [ " + i + "] = " + fiveAside[i]);

}

}

}




