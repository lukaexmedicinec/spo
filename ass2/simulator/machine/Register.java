public class Register{
    private Object[] registers;

    private static final int MASK = 0xFFFFFF;


    public static final int A = 0;
    public static final int X = 1;
    public static final int L = 2;
    public static final int B = 3;
    public static final int S = 4;
    public static final int T = 5;
    public static final int F = 6;
    public static final int PC = 8;
    public static final int SW = 9;

    public Register(){
        //inicializacija
        this.registers = new Object[9];
        for(int i = 0; i < 9; i++){
            if(i != 6)
                registers[i] = 0;
            else
                registers[i] = 0.0f;
        }
    }

    public int getA(){ return (int)registers[A];}
    public int getX(){ return (int)registers[X];}
    public int getL(){ return (int)registers[L];}
    public int getB(){ return (int)registers[B];}
    public int getS(){ return (int)registers[S];}
    public int getT(){ return (int)registers[T];}
    public float getF(){ return (float)registers[F];}
    public int getPC(){ return (int)registers[PC];}
    public int getSW(){ return (int)registers[SW];}
    
    private int skrajšaj(int val){
        return val & MASK;
    }


    public void setA(int val){this.registers[A] = skrajšaj(val);}
    public void setX(int val){this.registers[X] = skrajšaj(val);}
    public void setL(int val){this.registers[L] = skrajšaj(val);}
    public void setB(int val){this.registers[B] = skrajšaj(val);}
    public void setS(int val){this.registers[S] = skrajšaj(val);}
    public void setT(int val){this.registers[T] = skrajšaj(val);}
    public void setF(float val){this.registers[F] = val;}
    public void setPC(int val){this.registers[PC] = skrajšaj(val);}
    public void setSW(int val){this.registers[SW] = skrajšaj(val);}

    public Object getReg(int reg){
        if(reg >= 0 && reg < registers.length)
            return registers[reg];
        else
            throw new IndexOutOfBoundsException("Register index out of bounds");
    }

    public void setReg(int reg, Object val){
        if(reg < 0 || reg >= registers.length){
            throw new IndexOutOfBoundsException("Register index out of bounds");
        }
        else if(reg == F){
            if(val instanceof Float){
                registers[reg] = val;
            }
            else{
                throw new IllegalArgumentException("For a floating point register, floating point number required");
            }
        }
        else{
            if(val instanceof Integer){
                registers[reg] = skrajšaj((Integer) val);
            }
            else{
                throw new IllegalArgumentException("For a integer register, integer number required");
            }
        }
    }


    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("A: ").append(getA()).append(", ");
        sb.append("X: ").append(getX()).append(", ");
        sb.append("L: ").append(getL()).append(", ");
        sb.append("B: ").append(getB()).append(", ");
        sb.append("S: ").append(getS()).append(", ");
        sb.append("T: ").append(getT()).append(", ");
        sb.append("F: ").append(getF()).append(",  ");
        sb.append("PC: ").append(getPC()).append(", ");
        sb.append("SW: ").append(getSW());
        return sb.toString();
    }
}