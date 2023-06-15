import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class Node<T> {

    private List<Node<T>> adjacents;
    private int index;
    private final T payload;
    private int lowLink;

    public Node(List<Node<T>> adjacents, int index, T payload, int lowLink) {
        this.adjacents = adjacents;
        this.index = index;
        this.payload = payload;
        this.lowLink = lowLink;
    }

    public Node(int index, T payload, int lowLink) {
        this.index = index;
        this.payload = payload;
        this.lowLink = lowLink;
    }

    public List<Node<T>> getAdjacents() {
        return adjacents;
    }

    public T getPayload() {
        return payload;
    }

    public Integer getIndex() {
        return index;
    }

    void setIndex(int index) {
        this.index = index;
    }

    public Integer getLowLink() {
        return lowLink;
    }

    public void setLowLink(int lowLink) {
        this.lowLink = lowLink;
    }
}
