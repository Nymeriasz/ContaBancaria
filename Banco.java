package ContaBancaria;

public class Banco {
    public int numConta;
    protected String tipo;
    private String dono;
    private float saldo;
    private boolean status;

    public void estadoAtual(){
        System.out.println("--------------");
        System.out.println("Conta: "+this.getNumConta());
        System.out.println("Tipo: "+this.getTipo());
        System.out.println("Dono: "+this.getDono());
        System.out.println("Saldo: "+this.getSaldo());
        System.out.println("Status: "+this.getStatus());
    }

    public void abrirConta(String t){
        this.setTipo(t);
        this.setStatus(true);
        if (t == "CC"){
            this.setSaldo(50);
        } else if (t == "CP") {
            this.setSaldo(150);
        }
        System.out.println("Conta aberta");
    }
    public void fechaConta(){
        if (this.getSaldo() > 0){
            System.out.println("não pode fechar a conta, ainda tem dinheiro dentro");
        } else if (this.getSaldo() < 0) {
            System.out.println("não pode fechar conta, ta devendo");
        } else {
            this.setStatus(false);
            System.out.println("Conta não existe");
        }
    }
    public void depositar(float v){
        if (this.getStatus()){
            this.setSaldo(this.getSaldo() + v);
            System.out.println("Deposito feito na conta de "+this.getDono());
        } else {
            System.out.println("conta não existe");
        }
    }
    public void sacar(float v){
        if (this.getStatus()){
            if (this.getSaldo()>=v){
                this.setSaldo(this.getSaldo() - v);
                System.out.println("saque feito na conta de "+this.getDono());
            }else {
                System.out.println("saldo insuficiente pra saque");
            }
        }else {
            System.out.println("conta não existe");
        }
    }
    public void Anuidade(){
        int v=0;
        if (this.getTipo() == "CC"){
            v=12;
        } else if (this.getTipo() == "CP") {
            v=20;
        }
        if (this.getStatus()){
            this.setSaldo((this.getSaldo()-v));
            System.out.println("anuidade paga por "+this.getDono());
        }else {
            System.out.println("conta não existe");
        }
    }
    public void Banco(){ //construtor
        this.setSaldo(0);
        this.setStatus(false);
    }

    public void setNumConta(int n){
        this.numConta = n;
    }
    public int getNumConta(){
        return this.numConta;
    }

    public void setTipo(String t){
        this.tipo = t;
    }
    public String getTipo(){
        return this.tipo;
    }
    public void setDono(String d){
        this.dono = d;
    }
    public String getDono(){
        return this.dono;
    }
    public void setSaldo(float s){
        this.saldo = s;
    }
    public float getSaldo() {
        return this.saldo;
    }
    public void setStatus(Boolean st){
        this.status = st;
    }
    public Boolean getStatus(){
        return this.status;
    }
}
