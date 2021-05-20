package Services;

public class Pi1Service { //spigot

    private int[] digits;
    long timeout;
    private StringBuilder Result=new StringBuilder();

    // Produce digits
    public void run(int dig) {

        timeout = System.currentTimeMillis();

        int array_size_needed = dig *10/3+1;
        digits = new int[array_size_needed];

        // fill each digit with a 2
        for (int i=0; i<digits.length; i++)
            digits[i] =2;


        for (int i=0; i<dig; i++) {

            // Work backwards through the array, multiplying each digit by 10,
            // carrying the excess and leaving the remainder.
            int carry=0;
            for (int j=digits.length-1; j> 0; j--) {
                int numerator =j;
                int denomenator =j*2+1;
                int x =digits[j]*10+carry;
                digits[j] =x%denomenator;
                carry=x/denomenator *numerator;
            }

            // process the last digit
            int x =digits[0]*10+carry;
            digits[0] =x%10;
            int digit =x/10;

            // implement buffering and overflow
            if (digit<9) {
                flushDigits();
                // print a decimal after the leading "3"
                if (i==1) System.out.print(".");
                addDigit(digit);
            } else if (digit == 9) {
                addDigit(digit);
            } else {
                overflowDigits();
                flushDigits();
                addDigit(0);
            }
        }
        flushDigits();
        //System.out.println();
        timeout=System.currentTimeMillis()-timeout;
        //System.out.println("Digits of pi in "+timeout+" ms");
    }


    // write the buffered digits
    void flushDigits() {
        //System.out.append(Result);
        Result.setLength(0);
    }


    // given an integer 0..9, buffer a digit '0' .. '9'
    void addDigit(int digit) {
        Result.append((char)('0' + digit));
    }

    // add one to each digit, rolling over from from 9 to 0
    void overflowDigits() {
        for (int i=0; i < Result.length(); i++) {
            char digit = Result.charAt(i);

            if (digit == '9') {
                Result.setCharAt(i, '0');
            } else {
                Result.setCharAt(i, (char)(digit + 1));
            }
        }
    }

    public long getTimeout() {
        return timeout;
    }


}
