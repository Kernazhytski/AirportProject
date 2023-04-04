import React, {FC} from "react";
import "bootstrap/dist/css/bootstrap.min.css";

interface CenterComponents {
    children: React.ReactNode;
}
const Shedule: FC<CenterComponents> = ({children}) => {
    return (
        <div className="container d-flex justify-content-center align-items-center vh-100">
            <div className="row">
                <div className="col-md-6 d-flex flex-column justify-content-center">
                    {children}
                </div>
            </div>
        </div>
    );
};

export default Shedule;