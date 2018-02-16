
public class Fraction {
    //CONSTRUCTORS
    private int num,den;//Numerator and Denominator
    public Fraction(int num,int den)
    {
        this.num=num;
        this.den=den;
        if(this.den==0)
        {
           throw new IllegalArgumentException("The Denominator must be 0");
        }else if(this.den<0)
        {
            this.den=-(this.den);//makes denominator +ve
            this.num=-(this.num);//makes numerator -ve
        }

    }
    public Fraction(int p)
    {
       this.num=p;
       this.den=1;
    }
    public Fraction()
    {
        this.num=0;
    }
    //METHODS
    public int getNumerator()
    {
        return(this.num);
    }
    public int getDenominator()
    {
        return(this.den);
    }
    public String toString()
    {
        return(Integer.toString(this.num)+"/"+Integer.toString(this.den));
    }
    public Double toDouble()
    {
        return ((double)this.num/(double)this.den);
    }
    public Fraction add(Fraction other)
    {
        int newden=this.den*other.den;//to add fractions we have to multiply their denominators
        int newnum=(this.num*other.den)+(other.num*this.den);//new Numerator
        int number=gcd(newnum,newden);//it is the common greatest divisor
        return new Fraction(newnum/number,newden/number);
    }
    public Fraction subtract(Fraction other)
    {
        int newden=this.den*other.den;
        int newnum=(this.num*other.den)-(other.num*this.den);
        int number=gcd(newnum,newden);//it is the common greatest divisor

        return new Fraction(newnum/number,newden/number);
    }
    public Fraction multiply(Fraction other)
    {
        int newden=this.den*other.den;
        int newnum=this.num*other.num;
        int number=gcd(newnum,newden);//it is the common greatest divisor

        return new Fraction(newnum/number,newden/number);
    }
    public Fraction divide(Fraction other)
    {
        int newnum=this.num*other.den;
        int newden=this.den*other.num;
        int number=gcd(newnum,newden);//it is the common greatest divisor
        return new Fraction(newnum/number,newden/number);
    }
    public boolean equals(Fraction other)
    {
        this.toLowestTerms();
        other.toLowestTerms();
        return (this.num==other.num&&this.den==other.den);
    }
    public void toLowestTerms()
    {
     int number=gcd(this.num,this.den);//determines the greatest divisor of the numbers
        this.num/=number;
        this.den/=number;
    }
    public static int  gcd(int a,int b)
    {
        int rem=0;
        while (a!=0&&b!=0)
        {
            rem=a%b;
            a=b;
            b=rem;
        }
        return a;
    }
}
