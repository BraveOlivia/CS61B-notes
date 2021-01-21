public class Planet {

    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    private static final double G=6.67e-11;
    
	
	public Planet(double xP, double yP, double xV,
              double yV, double m, String img){
		xxPos=xP;
		yyPos=yP;
		xxVel=xV;
		yyVel=yV;
		mass=m;
		imgFileName=img;
	}

	public Planet(Planet b){
		xxPos=b.xxPos;
		yyPos=b.yyPos;
		xxVel=b.xxVel;
		yyVel=b.yyVel;
		mass=b.mass;
		imgFileName=b.imgFileName;
	}

	public double calcDistance(Planet b){
		double xDistance = Math.pow(b.xxPos-this.xxPos,2);
		double yDistance = Math.pow(b.yyPos-this.yyPos,2);
		return Math.sqrt(xDistance+yDistance);
	}

	public double calcForceExertedBy(Planet p){
		double r=calcDistance(p);
		return (G*this.mass*p.mass)/Math.pow(r,2);
	}

	public double calcForceExertedByX(Planet p){
		double dx = p.xxPos-this.xxPos;
		double F=calcForceExertedBy(p);
		double r=calcDistance(p);
		return (F*dx)/r;
	}

	public double calcForceExertedByY(Planet p){
		double dy = p.yyPos-this.yyPos;
		double F=calcForceExertedBy(p);
		double r=calcDistance(p);
		return (F*dy)/r;
	}


	public double calcNetForceExertedByX(Planet[] planets){
		double force=0;
		for(int i=0;i<planets.length;i++){
			if(planets[i]!=this){
				force += calcForceExertedByX(planets[i]);
			}
		}
		return force;
	}

	public double calcNetForceExertedByY(Planet[] planets){
		double force=0;
		for(int i=0;i<planets.length;i++){
			if(planets[i]!=this){
				force += calcForceExertedByY(planets[i]);
			}
		}
		return force;
	}


	public void update(double dt,double fX,double fY){
		double aX = fX/mass;
		double aY = fY/mass;
		this.xxVel = xxVel+dt*aX;
		this.yyVel =yyVel+dt*aY;
		this.xxPos = xxPos+dt*xxVel;
		this.yyPos =yyPos+dt*yyVel;
	}

	public void draw(){
		String imageToDraw = "images/"+imgFileName;
		StdDraw.picture(xxPos, yyPos, imageToDraw);
		StdDraw.show();
	}

}