package weekly_contest;

import java.text.DecimalFormat;
import java.util.Arrays;

public class W142_P1 {
	
public static double[] sampleStats(int[] count) {
        
	int var1=0;
	double min=Double.MAX_VALUE;
	double max = 0,sum=0,sum1=0,max2=0;
	int c=0;
	double mode=0;
	//DecimalFormat df2 = new DecimalFormat("#.#####");
	for(int i=0;i<count.length;i++)
	{
		if(count[i]!=0 && var1==0)
		{
			min=i;
			var1=1;
		}
		if(count[i]!=0 && i>max)
		{
			max=i;
		}
		if(count[i]!=0)
			c++;
		
		if(count[i]>max2){
			
			max2=count[i];
			mode=i;
		}
			
		
		sum+=count[i]*i;
		
		sum1+=count[i];
		
	}
	
	double mean=sum/sum1,median=0;
	int med_index,sum2=0;
	if(sum1%2==0)
	{
		med_index=(int) (sum1/2);
	}
	else
	{
		med_index=(int) (sum1/2+1);
	}
	
	int i1 = 0,i2=0,var2=0,var3=0;
	for(int i=0;i<count.length;i++)
	{
		sum2+=count[i];
		if(sum2>=med_index+1)
		{
			if(var3==0)
			{
				i1=i;
			}
			i2=i;
			break;
		}
		
		if(sum2>=med_index && var2==0)
		{
			var3=1;
			i1=i;
			var2=1;
		}
		if(sum2>=(med_index+1))
		{
			i2=i;
		}
	}
	if(sum1%2==0)
	{
		median=(double)(i1+i2)/2;
	}
	else
	{
		median=i2;
	}
	
	
	
	return new double[]{min,max,mean,median,mode};
    }
	public static void main(String[] args) {
		int[] count=new int[]{0,4,3,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		
		int []c2=new int[]{0,1,3,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		
		System.out.println(Arrays.toString(sampleStats(count)));
	}
}
