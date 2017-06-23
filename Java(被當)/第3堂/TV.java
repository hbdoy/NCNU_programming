public class TV{
    protected int currentChannel=1;
    private int maxChannel=100;
    protected int price=10000;
    protected int bright=50; //Light
    public void increaseChannel(){
        currentChannel++;
        if(currentChannel>maxChannel)
            currentChannel=1;
    }
    public void decreaseChannel(){
        currentChannel--;
        if(currentChannel<1){
            currentChannel=maxChannel;
        }
    }
    public void setChannel(int c){
        if(c>maxChannel||c<1){
            return;
        }
        currentChannel=c;
    }
}
