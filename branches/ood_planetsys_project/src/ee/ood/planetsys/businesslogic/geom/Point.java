package ee.ood.planetsys.businesslogic.geom;



/**
 * @author Jaroslav Judin
 *
 */
public class Point {
	
	/**
	 * @param args
	 */
	private double x,y;
	
	public Point() { }
	/**
	 * 
	 * @param _x
	 * @param _y
	 */
	public Point(double _x, double _y) {
		this.x=_x;
		this.y=_y;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object p) {
		return (this.x()==((Point) p).x() && this.y()==((Point) p).y()) ? true : false;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.x()+
			"; "+this.y();
	}
	
	
	//Queries
	public double x(){
		return this.x;
	}
	
	public double y(){
		return this.y;
	}
	
	
	
	public double rho(){
		return Math.sqrt(x()*x() + y()*y());
	}
	
	public double theta(){
		return Math.atan2(y(), x());
	}
	
	public Point vectorTo(Point other){
		return new Point(other.x()-this.x(), other.y()-this.y());
	}
	
	public double distance(Point other){
		return this.vectorTo(other).rho();
	}
	
	
	//Commands
	
	public void translate(double dx, double dy){
		this.x+=dx;
		this.y+=dy;
	}
	
	public void scale(double factor){
		this.x*= factor;
		this.y*= factor;
	} 
	
	public void centre_rotate(double angle){
		  double temp_x = this.rho() * Math.cos(this.theta() + angle);
		  double temp_y = this.rho() * Math.sin(this.theta() + angle);
	      this.x=temp_x;
	      this.y=temp_y;
	}
	
	public void rotate(Point p, double angle){
		this.translate(-p.x(), -p.y());
		this.centre_rotate(angle);
		this.translate(p.x(), p.y());
	}
	
	public static void main(String[] args) {
		Point p = new Point(10.0, 20.0);
		Point p2 = new Point(17.0, 0.0);
		System.out.println(p);
		System.out.println(p2);
		System.out.println(p.distance(p2));
		
		

	}

}
