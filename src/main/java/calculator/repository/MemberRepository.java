package calculator.repository;


import calculator.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    public Member findOneEmail(String email) {
        Member result = new Member();
        try {
            result = em.createQuery("select m from Member m where m.email=:email", Member.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch(NoResultException e) {
            return null;
        }
        System.out.println(result);

        return result;
    }

    public List<Member> findByEmail(String email) {
        return em.createQuery("select m from Member m where m.email=:email", Member.class)
                .setParameter("email",email)
                .getResultList();
    }

}
