import java.util.*;

class node {
    int data;
    node right;
    node left;

    node(int data){
        this.data = data;
        this.left = null;
        this.right =null;
    }
}


//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {

    static public void technologia(node head, node tmp){
        if(head.data>tmp.data){// 만약 부모 노드가 더 크다면 왼쪽으로
            if(head.left != null){
                technologia(head.left,tmp);
            }
            else{
                head.left= tmp;
            }
        }
        else{ // 그렇지 않다면 오른쪽으로
            if(head.right != null){
                technologia(head.right,tmp);
            }
            else{
                head.right= tmp;
            }
        }
    }

    static public void search(node head){
        if(head == null)
            return;
        search(head.left);
        search(head.right);
        System.out.println(head.data);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<node> list = new LinkedList<node>();
        
        while (sc.hasNext()) {
            list.add(new node(sc.nextInt()));
        }

        node head = list.poll(); // 맨 위
        while(!list.isEmpty()){
            node h = list.poll();
            technologia(head,h);
        }
        search(head);




    }
}