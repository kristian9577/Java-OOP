package p02_OpenClosedPrinciple.p01_FileStream;

public class Progress {
    private final Entity entity;

    public Progress(Entity entity)
    {
        this.entity = entity;
    }

    public int getCurrentPercent()
    {
        return this.entity.getSent() * 100 / this.entity.getLength();
    }
}
