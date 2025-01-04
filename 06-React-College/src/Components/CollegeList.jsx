import React, { useEffect } from "react";
import { useCollege } from "../Services/ServiceIndex";

export function CollegeList() {

    const { allColleges, error, fetchAllColleges } = useCollege(); //using Custom Hooks

    //When the CollegeList Component mount it displays data.
    useEffect(() => {
        fetchAllColleges(); //to call API
    }, []);

    //If fails to load data from the backend.
    if (error) {
        return <div className="text-red-500">Error: {error.message}</div>;
    }

    return (
        <div className="p-4">
            <h1 className="text-xl font-semibold mb-4">All Available Colleges</h1>
            {allColleges.length === 0 ? (
                <p>No colleges available.</p>
            ) : (
                <ul>
                    {allColleges.map((college) => (
                        <li key={college.id} className="mb-4">
                            <h2 className="font-medium">College Name: {college.collegeName}</h2>
                            <p>Address: {college.location}</p>
                        </li>
                    ))}
                </ul>
            )}
        </div>
    );
}


