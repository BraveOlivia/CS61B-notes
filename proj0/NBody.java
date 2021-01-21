import java.util.ArrayList;

public class NBody{

	public static String bgimage = "images/starfield.jpg";
	public static double readRadius(String filename){
		In in = new In(filename);

		int numOfPlanets = in.readInt();
		double radius = in.readDouble();
		return radius;
	}

	public static Planet[] readPlanets(String filename){
		In in = new In(filename);

		int numOfPlanets = in.readInt();
		double radius = in.readDouble();
		Planet[] planets = new Planet[numOfPlanets];
		int index=0;

		while(in.hasNextLine() && index<numOfPlanets){
			double xxPos = in.readDouble();
			double yyPos = in.readDouble();
			double xxVel = in.readDouble();
			double yyVel = in.readDouble();
			double mass = in.readDouble();
			String imgUrl = in.readString();
			planets[index] = new Planet(xxPos,yyPos,xxVel,yyVel,mass,imgUrl);
			index++;
		}
		return planets;
	}

	public static void main(String[] args){
		double T=Double. parseDouble(args[0]);
		double dt=Double. parseDouble(args[1]);
		String filename=args[2];
		double radius = readRadius(filename);
		Planet[] planets = readPlanets(filename);
		
		StdDraw.setScale(-radius, radius);
		
		// StdDraw.picture(0, 0, bgimage);

		// System.out.println(planets.length);


		StdDraw.enableDoubleBuffering();

		double time=0;

		while(time<T){
			StdDraw.clear();
			double[] xForce=new double[planets.length];
			double[] yForce=new double[planets.length];

			for(int i=0;i<planets.length;i++){
				double netx = planets[i].calcNetForceExertedByX(planets);
				xForce[i]=netx;

				double nety = planets[i].calcNetForceExertedByY(planets);
				yForce[i]=nety;
			}	

			for(int i=0;i<planets.length;i++){
				planets[i].update(dt, xForce[i],yForce[i]);
			}

			StdDraw.picture(0, 0, bgimage);
			for(int i=0;i<planets.length;i++){
				planets[i].draw();
			}
			StdDraw.show();
			StdDraw.pause(10);

			time += dt;
		}

		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < planets.length; i++) {
    			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                  planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
}
	}
}