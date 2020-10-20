package controllers;

public interface DroneCommands {
    public void BeginProgram();

    public void EndProgram();

    public void FlyUp(int up);

    public void FlyDown(int down);

    public void FlyForward(int forward);

    public void FlyBackward(int backward);

    public void FlyLeft(int left);

    public void FlyRight(int right);

    public void XYZ(int x, int y, int z, int speed);

    public void SetSpeed(int speed);

    public void GetSpeed(int speed);

    public void Stop();
}
