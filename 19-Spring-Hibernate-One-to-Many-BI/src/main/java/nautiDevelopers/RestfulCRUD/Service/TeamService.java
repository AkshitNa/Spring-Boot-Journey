package nautiDevelopers.RestfulCRUD.Service;

import lombok.AllArgsConstructor;
import nautiDevelopers.RestfulCRUD.Model.Member;
import nautiDevelopers.RestfulCRUD.Model.Team;
import nautiDevelopers.RestfulCRUD.Repository.MemberRepository;
import nautiDevelopers.RestfulCRUD.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private MemberRepository memberRepository;

    // CRUD for Team
    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Optional<Team> getTeamById(Long id) {
        return teamRepository.findById(id);
    }

    public Team updateTeam(Long id, Team teamDetails) {
        Team team = teamRepository.findById(id).orElseThrow(() -> new RuntimeException("Team not found"));
        team.setName(teamDetails.getName());
        team.setMembers(teamDetails.getMembers());
        return teamRepository.save(team);
    }

    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
    }

    // CRUD for Member
    public Member createMember(Member member, Long teamId) {
        Team team = teamRepository.findById(teamId).orElseThrow(() -> new RuntimeException("Team not found"));
        member.setTeam(team); // Set the relationship
        return memberRepository.save(member);
    }
}

