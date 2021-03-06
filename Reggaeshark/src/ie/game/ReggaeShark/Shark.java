package ie.game.ReggaeShark;

import java.util.ArrayList;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;

public class Shark {
	
	private Bitmap bitmap;	
	private int x;			
	private int y;			
	private int Speed;
	private int inc;
	private int ScreenWidth;
	private int ScreenHeight;
	boolean up;
	float VertSpeed;
	public ArrayList<Bitmap> Blood = null;
	boolean death;
	
	float animTime=0;
	float totalAnimTime = 1;
	float numFrames;
	
	public Shark(Bitmap decodeResource, int i, int j, int screenWidth,int screenHeight)
	{
		this.bitmap = decodeResource;
		this.x = x;
		this.y = y;
		Speed=1;
		inc=0;
		VertSpeed = 0;
		ScreenWidth =screenWidth;
		ScreenHeight =screenHeight;
		death=false;
	}
	
	public void setBloodAnimation(ArrayList<Bitmap> animation){
		Blood = new ArrayList<Bitmap>(animation);
		numFrames = Blood.size();
	}
	
	public void draw(Canvas canvas)
	{
		if (!death)
		{
			canvas.drawBitmap(bitmap, (x - bitmap.getWidth()/2) +130, (y + bitmap.getHeight()/2), null);
			
		}
		else
		{
			int index = (int) (animTime/totalAnimTime*numFrames);
			if (index<numFrames)
				canvas.drawBitmap(Blood.get(index), (x - bitmap.getWidth()/2) + 180, (y - bitmap.getHeight()/2) + 80, null);
		}
	}
	public void update(float dt)//if shark crashes to the obsticles we add the animation variable to dt variable
	{
		if (death)
		{
			animTime += dt;
		}
		else//describing shark motion and shark update in its regular state
		{
			VertSpeed+=ScreenHeight/2*dt;
			if (up)
				VertSpeed-=ScreenHeight*dt*2;
			y+=VertSpeed*dt;
			
			if (y > ScreenHeight-100)	
			{
				y= (ScreenHeight-101);
				VertSpeed = 0;
			}
			else if(y < 1)
			{
				y = 2;
				VertSpeed = 0;
			}
			
		}
	}
	
	public boolean bump (Point OTL, Point OTR, Point OBR, Point OBL)//colision method, passing 4 points counting clockwise
	{
		Point TL = new Point(), TR = new Point(), BL = new Point(), BR = new Point();
		
		ArrayList<Point> PointList = new ArrayList<Point>(); //points for the loop
		PointList.add(OTL);
		PointList.add(OTR);
		PointList.add(OBR);
		PointList.add(OBL);
		
		getPoint(TL,TR,BL,BR);
		
		for (int i = 0; i<PointList.size(); i++){ //creating the loop that goes through the array to find intersecption
			if (BR.x>=PointList.get(i).x)
				if (TL.x<=PointList.get(i).x)
					if(PointList.get(i).y>=TL.y)
						if(PointList.get(i).y<=BR.y)
							
						return true;
		}
							
		PointList.clear();// we clear the array and check for collision again
	    PointList.add(TL);
		PointList.add(TR);
		PointList.add(BR);
		PointList.add(BL);
		
		for(int i = 0; i<PointList.size(); i++)
		{
			if (OBR.x>=PointList.get(i).x)
				if (OTL.x<=PointList.get(i).x)
					if(PointList.get(i).y>=OTL.y)
						if(PointList.get(i).y<=OBR.y)
		
						return true;
		}
			
		
		return false;
	}
	
	private void getPoint(Point TL, Point TR, Point BL, Point BR) {// method to get the point of the rectangle for collision
		// TODO Auto-generated method stub
		TL.x = (x - bitmap.getWidth()/2) +130;
		TL.y = (y - bitmap.getHeight() / 2) +150;
		
		TR.x = (x+bitmap.getWidth() / 2) +100;
		TR.y = (y - bitmap.getHeight() / 2) +150;
		
		BL.x = (x - bitmap.getWidth()/2) +130;
		BL.y = y + bitmap.getHeight() / 2;
		
		BR.x = (x+bitmap.getWidth() / 2)+100;
		BR.y = y+bitmap.getHeight() / 2;
	}
	

}
