public class Cell {
    int x, y;

    private CellStatus status = CellStatus.EMPTY;

    public void setStatus (CellStatus status) {  this.status = status;  }

    public CellStatus getStatus()  {  return status;  }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        return status == cell.status;
    }
}
