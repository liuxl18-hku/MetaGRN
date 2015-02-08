package org.omegahat.Simulation.RandomGenerators;

/**
 * Package to provide conversion from/to integer values <b>treated as unsigned</b>.
 * 
 * <body> This class is currenly incomplete.  Contributions are welcome.  
 * Potential additions include:
 * <ul>
 * <li> int unsignedAdd( int, int)
 * <li> int unsignedSubtract(int, int)
 * <li> int unsignedMultiply( int, int)
 * <li> int unsignedDivide(int, int)
 * <li> int unsignedModulus(int,int)
 * </ul>
 */
public  class Unsigned
{
 
    /**
     * Convert an int (treated as unsigned) to a long 
     */
    public static  long toLong(int u)
    {
        if (u<0) 
            return 0xFFFFFFFFL + (long) u + 1L;
        else
            return (long) u;
    }
    
    /** 
     *  Convert a long to an int (treated as unsigned) 
     *
     * <body> Note that in the current implementation, long negative
     * values are converted unchanged.  Thus, <b>fromLong(-1L)</b>
     * returns -1 as does fromLong( (long) (2.0^32.0-1.0) ) .
     */
    public static  int fromLong(long l)
    {
        if ( l > (long) Integer.MAX_VALUE)
            return (int) ( l - 0xFFFFFFFFL - 1L);
        else
            return (int) l;

    }

    /**
     * Convert an int (treated as unsigned) to a double
     */
    public static  double toDouble(int i)
    {
        return (double) toLong(i);
    }

    /** 
     *  Convert a double to an int (treated as unsigned) 
     *
     * <body> Note that in the current implementation, long negative
     * values are converted unchanged.  Thus, <b>fromDouble(-1.0)</b>
     * returns -1 as does fromDouble( (2.0^32.0-1.0) ) .
     */
   public static  double fromDouble(double d)
    {
        return fromLong( (long) d);
    }

}

