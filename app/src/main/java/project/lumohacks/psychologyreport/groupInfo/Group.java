package project.lumohacks.psychologyreport.groupInfo;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by David Liu on 9/15/2018.
 */

public class Group {
    private List<Member> groupMembers;
    private String clientName;
    private int clientID;
    private int groupID;

    public Group(String clientName, int clientID, int groupID) {
        groupMembers = new ArrayList<>();
        this.clientName = clientName;
        this.clientID = clientID;
        this.groupID = groupID;
    }

    public void addMember(MemberType memberType, String name, String email, int phoneNumber,
                          String relationWithClient, String password) {

        Member memberToAdd = new Member(memberType, name, email, phoneNumber, relationWithClient, password);
        groupMembers.add(memberToAdd);
    }

    public boolean memberExist(String memberName, String password){
        for(Member member: groupMembers){
            if(member.getName().equals(memberName) && member.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    public String[] getGroupMember(){
        List<String> groupList = new ArrayList<>();
        for(Member member : groupMembers){
            if(member.getMemberType() != MemberType.HealthProfessional){
                groupList.add(member.getName());
            }
        }
        return groupList.toArray(new String[groupList.size()]);
    }

    public MemberType getMemberType(String username){
        for(Member member: groupMembers){
            if(member.getName().equals(username)){
                return member.getMemberType();
            }
        }
        return null;
    }

    public void removeMember(String memberName) {

        Iterator<Member> m = groupMembers.iterator();
        while (m.hasNext()) {
            Member member = m.next();
            if (member.getName().equals(memberName)) {
                m.remove();
            }
        }
    }

    // getters
    public String getClientName() {
        return clientName;
    }

    public int getClientID() {
        return clientID;
    }

    public int getGroupID() {
        return groupID;
    }
}
