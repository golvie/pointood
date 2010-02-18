
public class test {
	public static void main(String[] args) {
		Controller c = new Controller();
		String flag="";
		while(!flag.equalsIgnoreCase("s")){
			flag=input.getFlag();
			if(flag.equalsIgnoreCase("a")){
				c.add(input.getCoord("x"), input.getCoord("y"));
				c.print();
			}
			else if(flag.equalsIgnoreCase("r")){
				c.remove(input.getCoord("x"), input.getCoord("y"));
				c.print();
			}
			else if(flag.equalsIgnoreCase("d"))
				c.print();
		}	
	}
}
