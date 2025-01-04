package nautiDevelopers.RestfulCRUD.Controller;

import lombok.AllArgsConstructor;
import nautiDevelopers.RestfulCRUD.Model.Member;
import nautiDevelopers.RestfulCRUD.Model.Team;
import nautiDevelopers.RestfulCRUD.Service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    // CRUD for Team

    //http://localhost:8080/api/teams
    @PostMapping
    public ResponseEntity<Team> createTeam(@RequestBody Team team) {
        Team createdTeam = teamService.createTeam(team);
        return ResponseEntity.ok(createdTeam);
    }

    //http://localhost:8080/api/teams/getAll
    @GetMapping("/getAll")
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

    //http://localhost:8080/api/teams/101
    @GetMapping("/{id}")
    public ResponseEntity<Team> getTeamById(@PathVariable Long id) {
        Optional<Team> team = teamService.getTeamById(id);
        return team.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //http://localhost:8080/api/teams/101
    @PutMapping("/{id}")
    public ResponseEntity<Team> updateTeam(@PathVariable Long id, @RequestBody Team teamDetails) {
        Team updatedTeam = teamService.updateTeam(id, teamDetails);
        return ResponseEntity.ok(updatedTeam);
    }

    //http://localhost:8080/api/teams/101
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeam(@PathVariable Long id) {
        teamService.deleteTeam(id);
        return ResponseEntity.noContent().build();
    }

    // CRUD for Member
    //http://localhost:8080/api/teams/101/5
    @PostMapping("/{teamId}/members")
    public ResponseEntity<Member> createMember(@PathVariable Long teamId, @RequestBody Member member) {
        Member createdMember = teamService.createMember(member, teamId);
        return ResponseEntity.ok(createdMember);
    }
}

